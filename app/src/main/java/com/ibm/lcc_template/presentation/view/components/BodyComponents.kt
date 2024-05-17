package com.ibm.lcc_template.presentation.view.components

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ibm.lcc_template.data.model.Product
import com.ibm.lcc_template.presentation.UIState
import com.ibm.lcc_template.presentation.viewmodel.ProductsViewModel

@Composable
fun BodyComponents(viewModel: ProductsViewModel) {

    val stateFlow by viewModel.uiState.collectAsState()

    Column {
        Box(
            modifier = Modifier.align(Alignment.End)
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            }
        }
        when (val state = stateFlow) {
            is UIState.Error -> {

            }

            UIState.Loading -> {

            }

            is UIState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .weight(1.0f)
                ) {

                    items(state.response) { productItem ->
                        Spacer(modifier = Modifier.height(8.dp))
                        ProductItemCard(item = productItem, viewModel)
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                }
            }
        }
    }

}


@Composable
fun ProductItemCard(item: Product, viewModel: ProductsViewModel) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Image(
                painter = rememberImagePainter(data = item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier
                    .weight(1.0f)
                    .padding(8.dp)
            ) {

                Row {
                    Text(
                        text = item.title,
                        modifier = Modifier
                            .weight(1.0f)
                            .align(Alignment.Top),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Box {
                        Column(

                        ) {
                            IconButton(onClick = {
                                viewModel.insertProductShopping(item)
                            }) {
                                Icon(
                                    Icons.Default.AddCircle,
                                    contentDescription = null
                                )
                            }
                            Text(
                                text = item.rating.rate.toString(), modifier = Modifier.align(
                                    Alignment.CenterHorizontally
                                )
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "$ ${item.price}", fontWeight = FontWeight.Light, fontStyle = FontStyle.Italic)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = item.description, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}