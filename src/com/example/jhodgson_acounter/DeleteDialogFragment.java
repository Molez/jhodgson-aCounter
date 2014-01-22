package com.example.jhodgson_acounter;

import android.content.Context;
import android.view.View;

/*This class extends the basic custom dialog fragment and defines what actions
a delete fragment should take. This fragment is used to prompt the user before
deleting a counter to verify that the user does indeed want to delete the current
counter*/

public class DeleteDialogFragment extends CustomDialogFragment {

	void doThis(View view, View parentView, Context context) {
		CounterListController listController = new CounterListController();
		listController.deleteCurrentCounter();
		listController.saveState(context); //Save the delete
		getActivity().finish();
	}
}
