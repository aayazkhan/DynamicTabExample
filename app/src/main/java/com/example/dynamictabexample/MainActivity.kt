package com.example.dynamictabexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamictabexample.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model1Child1 = Model("A1", null)
        val model1Child2 = Model("A2", null)
        val model1Child3 = Model("A3", null)

        val model1List = listOf( model1Child1,model1Child2, model1Child3 )

        var model1 = Model("A", model1List);

        val model2Child1 = Model("B1", null)
        val model2Child2 = Model("B2", null)
        val model2Child3 = Model("B3", null)

        val model2List = listOf( model2Child1,model2Child2, model2Child3 )

        var model2 = Model("B", model2List);

        val model3Child1 = Model("C1", null)
        val model3Child2 = Model("C2", null)
        val model3Child3 = Model("C3", null)

        val model3List = listOf( model3Child1,model3Child2, model3Child3 )

        var model3 = Model("C", model3List);


        loadTabs(models = listOf(model1, model2, model3))

    }

    private fun loadTabs(models: List<Model>) {

        val tabLayout = TabLayout(this)
        for (tabValue in models) {
            val newTab = tabLayout.newTab()
            newTab.text = tabValue.name
            newTab.tag = tabValue
            tabLayout.addTab(newTab)
        }

        tabLayout.addOnTabSelectedListener(onTabSelectedListener())

        tabLayout.selectTab(tabLayout.getTabAt(0))

        binding.root.addView(tabLayout)

    }

    inner class onTabSelectedListener : OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {

            val model: Model = tab.tag as Model

            Toast.makeText(this@MainActivity, model.name, Toast.LENGTH_LONG).show()

            if (model.child != null) {
                loadTabs(model.child)
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {}
        override fun onTabReselected(tab: TabLayout.Tab) {}
    }


}