package com.creativedrewy.nativ.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.creativedrewy.nativ.R
import com.creativedrewy.nativ.ui.theme.HotPink
import com.creativedrewy.nativ.ui.theme.TitleGray
import com.creativedrewy.nativ.ui.theme.Turquoise
import com.creativedrewy.nativ.viewmodel.DetailsViewModel
import com.google.accompanist.flowlayout.FlowRow
import java.util.*

@Composable
fun DetailsScreen(
    nftId: String,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(
        key1 = Unit,
        block = {
            viewModel.loadNftDetails(nftId)
        }
    )

    val loadedNft by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colors.primaryVariant)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .background(MaterialTheme.colors.primaryVariant)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    painter = painterResource(
                        id = R.drawable.perspective_grid_variant
                    ),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = ""
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(
                    top = 8.dp
                ),
            text = loadedNft.name,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onPrimary
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 8.dp
                ),
            text = loadedNft.description,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onPrimary
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 8.dp
                ),
            text = loadedNft.siteUrl,
            style = MaterialTheme.typography.body2,
            color = Turquoise
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 8.dp
                ),
            text = "Attributes",
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onPrimary
        )

        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            loadedNft.attributes.forEach { attrib ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .border(
                            border = BorderStroke(2.dp, HotPink),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text(
                            text = attrib.name.uppercase(Locale.getDefault()),
                            color = TitleGray
                        )
                        Text(
                            text = attrib.value,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            }
        }
    }
}
