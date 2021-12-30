/*
 * Copyright (C) By the Author
 * Author    Yura Krymlov
 * Created   2021-01
 */

package org.jyotisa.api.lagna;

/**
 * 8. Indu
 *
 * @author Yura Krymlov
 * @version 1.0, 2021-01
 */
public interface ILagnaIndu extends ILagna {

    @Override
    default int fid() {
        return 8;
    }

    @Override
    default String code() {
        return L8_CD;
    }

}
