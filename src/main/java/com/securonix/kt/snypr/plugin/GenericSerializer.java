package com.securonix.kt.snypr.plugin;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GenericSerializer<T extends Object> {

    private final Class<T> type;
    private final boolean kryoEnabled;
    private Kryo kryo;

    public GenericSerializer(Class<T> type, boolean kryoEnabled) {

        this.type = type;
        this.kryoEnabled = kryoEnabled;
        if (kryoEnabled) {
            kryo = new Kryo();
            kryo.register(type);
        }
    }

    public byte[] serialize(Object object) throws Exception {

        byte[] bytes = null;

        if (type.isInstance(object)) {
            if (!kryoEnabled) {
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(baos);) {
                    out.writeObject(object);
                    bytes = baos.toByteArray();
                }
            } else {
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); Output out = new Output(baos);) {
                    kryo.writeObject(out, object);
                    out.flush();
                    bytes = baos.toByteArray();
                }
            }
        }

        return bytes;

    }

    public T deserialize(byte[] bytes) throws Exception {

        T object;

        if (!kryoEnabled) {

            try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes); ObjectInputStream in = new ObjectInputStream(bais);) {
                object = type.cast(in.readObject());
            }
        } else {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes); Input in = new Input(bais);) {
                object = kryo.readObject(in, type);
            }
        }

        return object;
    }

}
