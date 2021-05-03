package com.simplelibclient;

import com.simplelib.ExternalDependency1;
import com.simplelib.ExternalDependency2;
import com.simplelibclient.internaldeps.InternalDependency;

public class ClientForExternalDependency1 {
    public void doStuff1() {
        ExternalDependency1 ed1 = new ExternalDependency1();
        ed1.doSomethingCool();

        InternalDependency id = new InternalDependency();
        id.runInternalAction();
    }
}
