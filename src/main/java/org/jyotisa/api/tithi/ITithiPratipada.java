/*
 * Copyright (C) By the Author
 * Author    Yura Krymlov
 * Created   2021-01
 */

package org.jyotisa.api.tithi;

/**
 * 1. Pratipada
 *
 * @author Yura Krymlov
 * @version 1.0, 2021-01
 */
public interface ITithiPratipada extends ITithi {

    @Override
    default int fid() {
        return 1;
    }

    @Override
    default String code() {
        return S01_CD;
    }

}
