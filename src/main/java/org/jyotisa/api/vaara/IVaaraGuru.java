/*
 * Copyright (C) By the Author
 * Author    Yura Krymlov
 * Created   2021-01
 */
package org.jyotisa.api.vaara;

/**
 * 5. Guruvaara
 *
 * @author Yura Krymlov
 * @version 1.0, 2021-01
 */
public interface IVaaraGuru extends IVaara {

    @Override
    default int fid() {
        return 5;
    }

    @Override
    default String code() {
        return GUVR_CD;
    }

}
