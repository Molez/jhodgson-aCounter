package com.example.jhodgson_acounter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class DeleteDialogFragment extends CustomDialogFragment {

	void doThis(View view, View parentView, Context context) {
		CounterListController listController = new CounterListController();
		listController.deleteCurrentCounter();
		listController.saveState(context);
		Intent intent = new Intent(getActivity(), MainActivity.class);
		startActivity(intent);
	}
}
