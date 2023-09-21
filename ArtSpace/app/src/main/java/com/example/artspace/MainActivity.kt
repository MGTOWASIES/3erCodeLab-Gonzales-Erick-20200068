package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceImages()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceImages(modifier: Modifier = Modifier) {

    val primeraImg= R.drawable.leonardo_da_vinci___mona_lisa_louvre_paris
    val segundaImg= R.drawable.nocheestrellada
    val terceraImg= R.drawable.elbeso
    val cuartaImg= R.drawable.ultimacena
    var quintaImg= R.drawable.elgrito
    var sextaImg= R.drawable.guernica

    var title by remember {
        mutableStateOf(R.string.monalisa)
    }

    var autor by remember {
        mutableStateOf(R.string.monalisa_autor)
    }

    var year by remember {
        mutableStateOf(R.string.monalisa_year)
    }

    var currentArtwork by remember {
        mutableStateOf(primeraImg)
    }

    var imageResource by remember {
        mutableStateOf(currentArtwork)
    }


    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkDisplay(currentArtwork = currentArtwork)
        Spacer(modifier = modifier.size(16.dp))
        Titulo(title = title, autor = autor, year = year)
        Spacer(modifier = modifier.size(25.dp))
        Row(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            //horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Spacer izquierdo para centrar el botón "Anterior"
            Spacer(modifier = modifier.weight(0.0001f))
            Button(
                onClick = {
                    when (currentArtwork) {
                        primeraImg -> {
                            currentArtwork = sextaImg
                            title = R.string.guernica
                            autor = R.string.guernica_autor
                            year = R.string.guernica_year
                        }
                        segundaImg -> {
                            currentArtwork = primeraImg
                            title = R.string.monalisa
                            autor = R.string.monalisa_autor
                            year = R.string.monalisa_year
                        }
                        terceraImg -> {
                            currentArtwork = segundaImg
                            title = R.string.lanocheestrellada
                            autor = R.string.lanocheestrellada_autor
                            year = R.string.lanocheestrellada_year
                        }
                        cuartaImg -> {
                            currentArtwork = terceraImg
                            title = R.string.elbeso
                            autor = R.string.elbeso_autor
                            year = R.string.elbeso_year
                        }
                        quintaImg -> {
                            currentArtwork = cuartaImg
                            title = R.string.guernica
                            autor = R.string.guernica_autor
                            year = R.string.guernica_year
                        }
                        else -> {
                            currentArtwork = quintaImg
                            title = R.string.elgrito
                            autor = R.string.elgrito_autor
                            year = R.string.elgrito_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_700)/*previous*/
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Anterior",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white) /*previous*/
                )
            }

            // Spacer derecho para centrar el botón "Siguiente"
            Spacer(modifier = modifier.weight(0.1f))

            Button(
                onClick = {
                    when (currentArtwork) {
                        primeraImg -> {
                            currentArtwork = segundaImg
                            title = R.string.lanocheestrellada
                            autor = R.string.lanocheestrellada_autor
                            year = R.string.lanocheestrellada_year
                        }
                        segundaImg -> {
                            currentArtwork = terceraImg
                            title = R.string.elbeso
                            autor = R.string.elbeso_autor
                            year = R.string.elbeso_year
                        }
                        terceraImg -> {
                            currentArtwork = cuartaImg
                            title = R.string.laultimacena
                            autor = R.string.laultimacena_autor
                            year = R.string.laultimacena_year
                        }
                        cuartaImg -> {
                            currentArtwork = quintaImg
                            title = R.string.elgrito
                            autor = R.string.elgrito_autor
                            year = R.string.elgrito_year
                        }
                        quintaImg -> {
                            currentArtwork = sextaImg
                            title = R.string.guernica
                            autor = R.string.guernica_autor
                            year = R.string.guernica_year
                        }
                        else -> {
                            currentArtwork = primeraImg
                            title = R.string.monalisa
                            autor = R.string.monalisa_autor
                            year = R.string.monalisa_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_700)/*Next*/
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Siguiente",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)/*Next*/
                )
            }
        }
    }
}

@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.lanocheestrellada),
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun Titulo(
    @StringRes title: Int,
    @StringRes autor: Int,
    @StringRes year: Int
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Titulo
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            fontSize = 32.sp
        )

        // Autor
        Text(
            text = "Autor: ${stringResource(id = autor)}",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            fontSize = 16.sp
        )

        // Anio
        Text(
            text = "Publicacion: ${stringResource(id = year)}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.purple_200)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceImages()
    }
}