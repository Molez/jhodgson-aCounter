package com.example.jhodgson_acounter;

import android.content.Intent;
import android.view.View;

public class DeleteDialogFragment extends CustomDialogFragment {

	void doThis(View view, View parentView) {
		CounterListController listController = new CounterListController();
		listController.deleteCurrentCounter();
		Intent intent = new Intent(getActivity(), MainActivity.class);
		startActivity(intent);
	}
}
