package com.securonix.kt.snypr.plugin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class EventCompressor {

    public enum COMPRESSION_TYPE {
        GZIP("gzip"), SNAPPY("snappy"), BZIP2("bzip2"), LZO("lzo"), NONE("none");

        private final String value;
        private final static Map<String, COMPRESSION_TYPE> map = new HashMap<>();

        static {
            for (COMPRESSION_TYPE cType : COMPRESSION_TYPE.values()) {
                map.put(cType.value, cType);
            }
        }

        COMPRESSION_TYPE(final String newValue) {
            value = newValue;
        }

        public static COMPRESSION_TYPE getByValue(String value) {
            COMPRESSION_TYPE ct = map.get(value);
            if (ct == null) {
                ct = COMPRESSION_TYPE.NONE;
            }
            return ct;
        }
    };

    public static byte[] compress(final ArrayList<String> list, String compressiontype) throws Exception {

        final byte[] bytes = new GenericSerializer<>(ArrayList.class, true).serialize(list);
        COMPRESSION_TYPE ct = COMPRESSION_TYPE.valueOf(compressiontype.toUpperCase());

        byte[] compressedBytes = null;

        switch (ct) {
            case GZIP:
                compressedBytes = gzipCompress(bytes);
                break;

            case NONE:
                compressedBytes = bytes;
                break;

            default:
                System.err.println("Compression Type - {} not supportd Please use gzip or snappy or bzip2 or lzo ");

        }

        return compressedBytes;
    }

    public static byte[] compress(final String data, String compressiontype) throws Exception {

        final byte[] bytes = new GenericSerializer<>(String.class, true).serialize(data);
        COMPRESSION_TYPE ct = COMPRESSION_TYPE.valueOf(compressiontype.toUpperCase());

        byte[] compressedBytes = null;

        switch (ct) {
            case GZIP:
                compressedBytes = gzipCompress(bytes);
                break;

            case NONE:
                compressedBytes = bytes;
                break;

            default:
                System.err.println("Compression Type - {} not supportd Please use gzip or snappy or bzip2 or lzo ");

        }

        return compressedBytes;
    }

    public static ArrayList<String> uncompress(final byte[] data, String compressiontype) throws Exception {

        COMPRESSION_TYPE ct = COMPRESSION_TYPE.valueOf(compressiontype.toUpperCase());
        byte[] unCompressedBytes = null;

        switch (ct) {
            case GZIP:
                unCompressedBytes = gzipUncompress(data);
                break;

            case NONE:
                unCompressedBytes = data;
                break;

            default:
                System.err.println("Compression Type - {} not supportd Please use gzip or snappy or bzip2 or lzo ");

        }

        return (ArrayList<String>) new GenericSerializer<>(ArrayList.class, true).deserialize(unCompressedBytes);
    }

    public static String uncompressString(final byte[] data, String compressiontype) throws Exception {

        COMPRESSION_TYPE ct = COMPRESSION_TYPE.valueOf(compressiontype.toUpperCase());
        byte[] unCompressedBytes = null;

        switch (ct) {
            case GZIP:
                unCompressedBytes = gzipUncompress(data);
                break;

            case NONE:
                unCompressedBytes = data;
                break;

            default:
                System.err.println("Compression Type - {} not supportd Please use gzip or snappy or bzip2 or lzo ");

        }

        return (String) new GenericSerializer<>(String.class, true).deserialize(unCompressedBytes);
    }

    private static byte[] gzipCompress(byte[] bytes) throws Exception {

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (GZIPOutputStream os = new GZIPOutputStream(baos)) {
            os.write(bytes, 0, bytes.length);
        }

        return baos.toByteArray();
    }

    private static byte[] gzipUncompress(final byte[] data) throws Exception {

        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        try (ByteArrayInputStream bais = new ByteArrayInputStream(data); GZIPInputStream is = new GZIPInputStream(bais)) {
            byte[] tmp = new byte[1024];
            int r;
            while (true) {
                r = is.read(tmp);
                if (r < 0) {
                    break;
                }
                buffer.write(tmp, 0, r);
            }
        }

        return buffer.toByteArray();
    }
}
