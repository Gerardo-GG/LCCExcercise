package com.ibm.lcc_template.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ibm.lcc_template.presentation.view.components.BodyComponents
import com.ibm.lcc_template.presentation.viewmodel.ProductsViewModel
import com.ibm.lcc_template.presentation.ui.theme.LCC_templateTheme
import dagger.hilt.android.AndroidEntryPoint

/*
Api tienda
https://fakestoreapi.com/products?limit=15
1.    Mostar una lista de articulos de un e-commerce
a.    Titulo
b.    Precio
c.    Descripción
d.    Imagen
e.    Calificación
2.    Opción de marcar articulos para compra posterior.
3.    Mostrar los articulos marcados.
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ProductsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAllProducts()
        setContent {
            LCC_templateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BodyComponents(viewModel = viewModel)
                }
            }
        }
    }
}