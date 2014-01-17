package com.example.jhodgson_acounter;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RenameDialogFragment extends CustomDialogFragment {
	
	void doThis(View view, View parentView) {
		EditText renameName = (EditText) view.findViewById(R.id.rename_name);
		String name = renameName.getText().toString();
		CounterListController listController = new CounterListController();
		if (name != null) {
			listController.renameCurrentCounter(name);
			TextView counterName = (TextView) parentView.findViewById(R.id.counter_name);
			counterName.setText(listController.getCurrentName());
		}
	}
}
