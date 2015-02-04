package br.ufal.ic.jcode;

import java.util.ArrayList;
import java.util.List;

public class Declaration {

    private String name;
    private List<String> modifiers;

    public Declaration() {
        modifiers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getModifiers() {
        return modifiers;
    }

    public void addModify(String modify) {
        this.modifiers.add(modify);
    }

    public void addModifiers(List<String> modifiers) {
        this.modifiers.addAll(modifiers);
    }

}
