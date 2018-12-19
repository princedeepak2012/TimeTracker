package com.tcs.tt.editors;

import java.beans.PropertyEditorSupport;

import com.tcs.tt.domain.Project;

public class EffortSpendEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String id) {
		Project d;
		switch (Integer.parseInt(id)) {
		case 1:
			d = new Project(1, "NormalHours");
			break;
		case 2:
			d = new Project(2, "OutOfOffice - Weekday");
			break;
		case 3:
			d = new Project(3, "OutOfOffice - Weekend");
			break;
		

		default:
			d = null;
		}
		this.setValue(d);
	}
}
