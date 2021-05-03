package com.simplelibclient;

import com.simplelib.ExternalDependency2;
import com.simplelibclient.internaldeps.InternalDependency;

public class ClientForExternalDependency2 {
    public void doStuff2() {
        ExternalDependency2 ed2 = new ExternalDependency2();
        ed2.doSomething();
    }
}
