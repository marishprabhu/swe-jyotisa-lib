/*
 * Copyright (C) By the Author
 * Author    Yura Krymlov
 * Created   2021-01
 */
package org.jyotisa.varga;

import org.jyotisa.api.rasi.IRasi;
import org.jyotisa.api.varga.IVarga;
import org.jyotisa.api.varga.IVargaD12;

import static org.jyotisa.rasi.ERasi.byLongitude;

/**
 * 12 Dwadasamsa
 *
 * @author Yura Krymlov
 * @version 1.0, 2021-01
 */
public enum VargaD12 implements IVargaD12 {
    D12;

    @Override
    public IVargaD12[] all() {
        return values();
    }

    @Override
    public IRasi rasi(final double longitudeInD1) {
        return byLongitude(virtualDegree(longitudeInD1));
    }

    @Override
    public double virtualDegree(double longitude) {
        return IVarga.getDvadasamsaLongitude(longitude);
    }
}
