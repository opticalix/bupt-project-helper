package com.opticalix.medicine;

import com.opticalix.algo.Matcher;
import com.opticalix.model.Medicine;
import com.opticalix.model.YjjMedicine;
import com.opticalix.tech_consult.CustomHiveServer2Auth;
import com.opticalix.utils.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JD: table name is medicine
 * YJJ: yjj_medicine, row cnt is 10w+, contains all data
 *
 * @author Felix
 */
public class Runner {

    private Map<Long, Long> mRelation = new HashMap<>();
    private List<Medicine> mMissMatchMedicineList = new ArrayList<>();
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomHiveServer2Auth.class);

    public void run() throws SQLException {
        long startTime = System.currentTimeMillis();
        MedicineDaoImpl daoImpl = new MedicineDaoImpl();
        List<Medicine> medicineList = daoImpl.query(Medicine.class, "select * from %s limit 1", DatabaseHelper.TABLE_NAME_JD_MEDICINE);

        if (medicineList == null) {
            return;
        }
        int targetNum = medicineList.size();
        for (Medicine medicine : medicineList) {
            YjjMedicine matchYjjMedicine = null;
            //try strategy 1
            matchYjjMedicine = Matcher.match(medicine, Matcher.MATCH_STRATEGY_LICENSE_EQUAL);
            if (matchYjjMedicine == null) {
                //try strategy 2
                matchYjjMedicine = Matcher.match(medicine, Matcher.MATCH_STRATEGY_BRAND_NAME_LIKE);
            }
            if (matchYjjMedicine == null) {
                //try strategy 3
                matchYjjMedicine = Matcher.match(medicine, Matcher.MATCH_STRATEGY_MEDICINE_NAME_LIKE);
            }
            if (matchYjjMedicine != null) {
                mRelation.put(matchYjjMedicine.getId(), medicine.getId());
            } else {
                //check out which medicine is missing
                mMissMatchMedicineList.add(medicine);
            }
        }
        long spendSec = (System.currentTimeMillis() - startTime) / 1000;
//        Logger.p("targetNum=%d, matchNum=%d, completeRate=%.2f%%, useTime=%ds", targetNum, mRelation.size(), 100 * mRelation.size() / (float) targetNum, spendSec);
//        Logger.p(mRelation.toString());
        LOGGER.info(String.format("targetNum=%d, matchNum=%d, completeRate=%.2f%%, useTime=%ds", targetNum, mRelation.size(), 100 * mRelation.size() / (float) targetNum, spendSec));
    }

}
