package com.example.jhodgson_acounter;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*This class extends the basic custom dialog fragment and defines what actions
a rename fragment should take. This fragment is used to prompt the user for
a string which signifies the new name the current counter should take.*/

public class RenameDialogFragment extends CustomDialogFragment {

	void doThis(View view, View parentView, Context context) {
		EditText renameName = (EditText) view.findViewById(R.id.rename_name);
		String name = renameName.getText().toString();
		CounterListController listController = new CounterListController();
		if (name != null) {
			listController.renameCurrentCounter(name);
			TextView counterName = (TextView) parentView
					.findViewById(R.id.counter_name);
			counterName.setText(listController.getCurrentName());
			listController.saveState(context);
		}
	}
}
