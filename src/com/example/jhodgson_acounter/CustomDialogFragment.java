package com.example.jhodgson_acounter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/*Creates a new custom pop-up alert dialog. The action of this 
 dialog is defined by the doDo() function. The dialog gets the 
 button names an the layout from a bundle passed with the calling
 of this class. All fragments use the same build code but different
 actions.*/

public abstract class CustomDialogFragment extends DialogFragment {

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		Bundle bundle = getArguments();

		int button1 = (Integer) bundle.get("button1");
		int button2 = (Integer) bundle.get("button2");
		int layout = (Integer) bundle.get("layout");

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View v = inflater.inflate(layout, null);
		builder.setView(v);

		builder.setPositiveButton(button2,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						doThis(v, getActivity().getWindow().getDecorView(), getActivity());
					}
				}).setNegativeButton(button1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// User cancelled the dialog
					}
				});
		// Create the AlertDialog object and show it
		return builder.create();
	}

	//Must define what this fragment does on "accept" through this method.
	abstract void doThis(View view, View parentView, Context context);
}
