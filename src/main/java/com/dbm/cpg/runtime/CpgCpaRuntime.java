package com.dbm.cpg.runtime;

import com.dbm.cpg.model.*;

public interface CpgCpaRuntime {
    CpgCpaResult run(StructuralGraph input, RuntimeContext context);
}
