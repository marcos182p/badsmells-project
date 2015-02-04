package br.ufal.ic.jcode;

import java.util.ArrayList;
import java.util.List;

public class Field extends JavaEntity {

    private String type;
    private Declaration declaration;
    private List<Fragment> fragments;

    public Field() {
        super(EntityType.FIELD);
        fragments = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

    public void addFragments(List<Fragment> fragments) {
        fragments.addAll(fragments);
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public String toString() {
        return "\n Field [modifiers=" + declaration.getModifiers() + ", type=" + type
                + ", fragments=" + fragments + "]";
    }

}
