package br.eng.rozsas.upsmonitor;

public class OIDData {
    // oid
    private String oid;

    // textual representation of oid
    private String name;

    // human readable description of oid
    private String description;

    // multiplier to be applied to convert some data from int to float
    private float mult;

    // type
    private ResultType type;

    // Choices
    private String[] choices;

    // suffix to be applied to data
    private String suffix;

    // finally, the value associated to the this oid data
    private String value;

    public OIDData(String oid, String name, String description, float mult, ResultType type, String[] choices, String suffix) {
        this.oid = oid;
        this.name = name;
        this.description = description;
        this.mult = mult;
        this.type = type;
        this.choices = choices;
        this.suffix = suffix;
        this.value= "";
    }

    // this constructor is just for  test purposes. can be removed at final version
    public OIDData(String oid, String name, String description) {
        this.oid = oid;
        this.name = name;
        this.description = description;
        this.mult = 1.0f;
        this.type = null;
        this.choices = null;
        this.suffix = "";
        this.value= "";
    }
    public String getOid() {
        return oid;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public float getMult() {
        return mult;
    }

    public ResultType getType() {
        return type;
    }

    public String[] getChoices() {
        return choices;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value= value;
    }
}
