package br.com.idtrust.examples.mongodb;

import com.mongodb.MongoClient;
import br.com.idtrust.examples.mongodb.entity.Employee;
import org.mongodb.morphia.Morphia;

public class Datastore {

    private static org.mongodb.morphia.Datastore INSTANCE;

    public static org.mongodb.morphia.Datastore getInstance() {

        if (INSTANCE == null) {
            final Morphia morphia = new Morphia();
            morphia.map(Employee.class);
            final org.mongodb.morphia.Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
            datastore.ensureIndexes();
            INSTANCE = datastore;
        }

        return INSTANCE;
    }


}
