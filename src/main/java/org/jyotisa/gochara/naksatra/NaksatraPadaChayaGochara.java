/*
* Copyright (C) By the Author
* Author    Yura Krymlov
* Created   2020-06
*/

package org.jyotisa.gochara.naksatra;

import org.jyotisa.api.IKundali;
import org.jyotisa.api.naksatra.INaksatraPada;
import org.jyotisa.api.naksatra.INaksatraPadaEntity;
import org.jyotisa.naksatra.ENaksatraPada;
import org.swisseph.api.ISweSegment;

import static org.swisseph.api.ISweConstants.*;
import static org.swisseph.api.ISweObjects.RA;
import static org.swisseph.utils.IModuloUtils.fix360;

/**
 * @author  Yura Krymlov
 * @version 1.0, 2020-06
 */
public class NaksatraPadaChayaGochara extends NaksatraPadaGochara {
    protected final boolean rahu;

    public NaksatraPadaChayaGochara(IKundali kundali) {
        this(kundali, true);
    }
    
    public NaksatraPadaChayaGochara(IKundali kundali, boolean forward) {
        this(kundali, true, forward);
    }

    public NaksatraPadaChayaGochara(IKundali kundali, boolean rahu, boolean forward) {
        super(kundali, kundali.chayaGraha(rahu), forward);
        this.rahu = rahu;
    }
    
    @Override
    public INaksatraPadaEntity newTransitEntity() {
        double offset = transitCalc.getOffset();
        
        if ( ! rahu ) {
            offset += d180;
            offset = fix360(offset);
        }

        final INaksatraPada eenum = ENaksatraPada.byLongitude(offset);
        return new NaksatraPadaEntity(offset, graha, eenum, julianDay);
    }
    
    @Override
    public double getStartOffset() {
        final double longitude = kundali.sweObjects().longitudes()[RA];
        final ISweSegment interval = ENaksatraPada.byLongitude(longitude).segment();
        return forward ? interval.close() : interval.start();
    }
    
    @Override
    public double getNextOffset(final INaksatraPadaEntity entity) {
        double offset = transitCalc.getOffset();
        if ( offsetStep == d0 ) return offset;
        if ( forward ) offset -= offsetStep;
        else offset += offsetStep;
        offset += DSTEP_ROUND;
        return fix360(offset);
    }

}
