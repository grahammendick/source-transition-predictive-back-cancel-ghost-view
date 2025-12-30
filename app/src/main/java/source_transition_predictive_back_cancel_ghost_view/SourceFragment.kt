package sample.source_transition_predictive_back_cancel_ghost_view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.transition.Fade

class SourceFragment : Fragment(R.layout.fragment_source) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Either transition will cause the bug
        exitTransition = Fade()
        // reenterTransition = Fade()

        val logoView: View = view.findViewById(R.id.android_logo)
        val button: Button = view.findViewById(R.id.toast_button)
        button.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.toast_text), Toast.LENGTH_SHORT).show()
        }
        logoView.setOnClickListener {
            val fm = requireActivity().supportFragmentManager
            fm.commit {
                setReorderingAllowed(true)
                addSharedElement(logoView, logoView.transitionName)
                replace<DestinationFragment>(R.id.content)
                addToBackStack(null)
            }
        }
    }
}