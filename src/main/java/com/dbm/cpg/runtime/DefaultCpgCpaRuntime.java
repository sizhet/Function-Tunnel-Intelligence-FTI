package com.dbm.cpg.runtime;

import com.dbm.cpg.cpa.CpaEngine;
import com.dbm.cpg.cpg.CpgEngine;
import com.dbm.cpg.model.*;
import java.util.*;

public final class DefaultCpgCpaRuntime implements CpgCpaRuntime {
    private final CpaEngine cpaEngine = new CpaEngine();
    private final CpgEngine cpgEngine = new CpgEngine(cpaEngine);

    public CpgCpaResult run(StructuralGraph input, RuntimeContext context) {
        CpaResult source = cpaEngine.analyze(input);
        List<PreservationReport> reports = cpgEngine.deriveAndValidate(source);
        return new CpgCpaResult(source, reports);
    }
}
