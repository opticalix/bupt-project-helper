package com.opticalix.algo;

import com.opticalix.medicine.DatabaseHelper;
import com.opticalix.medicine.MedicineDaoImpl;
import com.opticalix.model.Medicine;
import com.opticalix.model.YjjMedicine;
import com.opticalix.utils.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * 加上索引后 733 * (select from 165619 rows), 约5s
 * @author Felix on 29/03/2018
 */
public class Matcher {
    public static final int MATCH_STRATEGY_LICENSE_EQUAL = 1;
    public static final int MATCH_STRATEGY_MEDICINE_NAME_LIKE = 2;
    public static final int MATCH_STRATEGY_BRAND_NAME_LIKE = 3;
    private static MedicineDaoImpl sMedicineDao = new MedicineDaoImpl();

    public static YjjMedicine match(Medicine m, int matchStrategy) throws SQLException {
        YjjMedicine ret;
        switch (matchStrategy) {
            case MATCH_STRATEGY_LICENSE_EQUAL:
                ret = matchByLicense(m);
                break;
            case MATCH_STRATEGY_BRAND_NAME_LIKE:
                ret = matchByBrand(m);
                break;
            case MATCH_STRATEGY_MEDICINE_NAME_LIKE:
                ret = matchByMedicine(m);
                break;
            default:
                ret = null;
        }
        return ret;
    }

    private static YjjMedicine matchByMedicine(Medicine m) throws SQLException {
        String drugName = m.getDrug_name();
        String pureDrugName = getPureDrugName(drugName);
//        Logger.p("pureDrugName=%s", pureDrugName);
        if (pureDrugName == null || "".equals(pureDrugName)) {
            return null;
        }
        List<YjjMedicine> yjjMedicines = sMedicineDao.query(YjjMedicine.class, "select * from %s where product_name like '%%%s%%'",
                DatabaseHelper.TABLE_NAME_YJJ_MEDICINE, pureDrugName.trim());
        if (yjjMedicines == null || yjjMedicines.size() == 0) {
            return null;
        }
        return yjjMedicines.get(0);
    }

    private static String getPureDrugName(String drugName) {
        String preHandleDrugName = drugName.trim().replaceAll("\\s+", " ");
        int indexOfFirstBlank = preHandleDrugName.indexOf(" ");
        int indexOfSecondBlank = preHandleDrugName.indexOf(" ", indexOfFirstBlank + 1);
        if (indexOfFirstBlank == -1) {
            return preHandleDrugName;
        }
        if (indexOfSecondBlank == -1) {
            return preHandleDrugName.substring(indexOfFirstBlank, preHandleDrugName.length());
        }
        return preHandleDrugName.substring(indexOfFirstBlank, indexOfSecondBlank);
    }

    private static YjjMedicine matchByLicense(Medicine m) throws SQLException {
        String licenseNumber = m.getLicense_number();
        if (licenseNumber == null || "".equals(licenseNumber)) {
            return null;
        }
        List<YjjMedicine> yjjMedicines = sMedicineDao.query(YjjMedicine.class, "select * from %s where approval_number='%s'",
                DatabaseHelper.TABLE_NAME_YJJ_MEDICINE, licenseNumber.trim());
        if (yjjMedicines == null || yjjMedicines.size() == 0) {
            return null;
        }
        return yjjMedicines.get(0);
    }

    private static YjjMedicine matchByBrand(Medicine m) throws SQLException {
        String brand = m.getBrand();
        if (brand == null || "".equals(brand)) {
            return null;
        }
        List<YjjMedicine> yjjMedicines = sMedicineDao.query(YjjMedicine.class, "select * from %s where goods_name like '%%%s%%'",
                DatabaseHelper.TABLE_NAME_YJJ_MEDICINE, brand.trim());
        if (yjjMedicines == null || yjjMedicines.size() == 0) {
            return null;
        }
        return yjjMedicines.get(0);
    }
}
