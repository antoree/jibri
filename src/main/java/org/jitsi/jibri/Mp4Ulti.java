package org.jitsi.jibri;

import com.coremedia.iso.IsoFile;
import org.jitsi.jibri.util.LoggingDoannh;

/**
 * created by: Nguyen Huy Doan
 * at: 12/11/2021 1:53 PM
 */
public class Mp4Ulti {
    public static Long getMp4FileInfo(String file) {
        try {
            IsoFile isoFile = new IsoFile(file);
            long lengthInSeconds =
                    isoFile.getMovieBox().getMovieHeaderBox().getDuration() /
                            isoFile.getMovieBox().getMovieHeaderBox().getTimescale();
            LoggingDoannh.Companion.log("video length in second: "+lengthInSeconds);
            return lengthInSeconds;
        } catch (Exception e) {
            e.printStackTrace();
            LoggingDoannh.Companion.log("ERROR: " + e.getMessage());
            return -1L;
        }
    }
}
