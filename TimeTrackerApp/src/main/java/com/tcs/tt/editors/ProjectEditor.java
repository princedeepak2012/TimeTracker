package com.tcs.tt.editors;

import java.beans.PropertyEditorSupport;

import com.tcs.tt.domain.Project;

public class ProjectEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String id) {
		Project d;
		switch (Integer.parseInt(id)) {
		case 1:
			d = new Project(1, "AIS");
			break;
		case 2:
			d = new Project(2, "API Garden");
			break;
		case 3:
			d = new Project(3, "API Multidevice");
			break;
		case 4:
			d = new Project(4, "AWS");
			break;
		case 5:
			d = new Project(5, "DevOps-Automation");
			break;
		case 6:
			d = new Project(6, "DevOps-GESB");
			break;
		case 7:
			d = new Project(7, "Finland Transformation Dev");
			break;
		case 8:
			d = new Project(8, "Finland Transformation Operation");
			break;
		case 9:
			d = new Project(9, "OWF");
			break;
		case 10:
			d = new Project(10, "Phoenix");
			break;

		default:
			d = null;
		}
		this.setValue(d);
	}
}
