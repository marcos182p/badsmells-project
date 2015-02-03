package br.ufal.ic.jcode;

import java.util.ArrayList;
import java.util.List;

public class Field extends AbstractDeclaration {
	
	private String type;
	private List<Fragment> fragments;

	public Field() {
		fragments = new ArrayList<Fragment>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void addFragment(Fragment fragment){
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
		return "\n Field [modifiers=" + getModifiers() + ", type=" + type
				+ ", fragments=" + fragments + "]";
	}
	
}
