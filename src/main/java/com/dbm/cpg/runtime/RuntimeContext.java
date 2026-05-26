package com.dbm.cpg.runtime;

public final class RuntimeContext {
    private final String profile;

    public RuntimeContext(String profile) { this.profile = profile == null ? "default" : profile; }
    public String getProfile() { return profile; }
}
