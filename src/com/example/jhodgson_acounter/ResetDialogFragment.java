package com.example.jhodgson_acounter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class ResetDialogFragment extends CustomDialogFragment {

	void doThis(View view, View parentView, Context context) {
		CounterListController listController = new CounterListController();
		listController.resetCounter();
		TextView count = (TextView) parentView
				.findViewById(R.id.counter_number);
		count.setText(String.valueOf(listController.getCurrentCount()));
		listController.saveState(context); //Save the reset
	}

}
