package com.example.jetpackcomposestudy.ui.elements

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.jetpackcomposestudy.R
import com.example.jetpackcomposestudy.ui.models.PostItemModel

@ExperimentalMaterialApi
@Composable
fun CardList(fakeDataSet: List<PostItemModel>, showComments: (item:PostItemModel)->Unit){
    LazyColumn() {
        items(items = fakeDataSet) { item ->
            ExpandableCard(
                item
            ) { showComments(item) }
        }
    }
}
