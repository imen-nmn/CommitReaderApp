package com.example.commitreaderapp.ui.commit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.commitreaderapp.R
import com.example.commitreaderapp.databinding.ItemCommitBinding
import com.example.commitreaderapp.model.Commit
/**
 * Adapter of commit list.
 */
class CommitListAdapter: RecyclerView.Adapter<CommitListAdapter.ViewHolder>() {
    private lateinit var commitList:List<Commit>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCommitBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_commit, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(commitList[position])
    }

    override fun getItemCount(): Int {
        return if(::commitList.isInitialized) commitList.size else 0
    }

    fun updateCommitList(commitList:List<Commit>){
        this.commitList = commitList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCommitBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = CommitViewModel()
        fun bind(commit:Commit){
            viewModel.bind(commit)
            binding.viewModel = viewModel
        }
    }
}