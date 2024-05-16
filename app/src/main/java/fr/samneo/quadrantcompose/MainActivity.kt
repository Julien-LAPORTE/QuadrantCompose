package fr.samneo.quadrantcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fr.samneo.quadrantcompose.ui.theme.Color1
import fr.samneo.quadrantcompose.ui.theme.Color2
import fr.samneo.quadrantcompose.ui.theme.Color3
import fr.samneo.quadrantcompose.ui.theme.Color4
import fr.samneo.quadrantcompose.ui.theme.QuadrantComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantComposeApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantComposeApp(modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(Modifier.weight(1f)) {
            QuadrantItem(
                title = R.string.title1,
                content = R.string.content1,
                color = Color1,
                Modifier.weight(1f)
            )
            QuadrantItem(
                title = R.string.title2,
                content = R.string.content2,
                color = Color2,
                Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantItem(
                title = R.string.title3,
                content = R.string.content3,
                color = Color3,
                Modifier.weight(1f)
            )
            QuadrantItem(
                title = R.string.title4,
                content = R.string.content4,
                color = Color4,
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantItem(
    @StringRes title: Int, @StringRes content: Int, color: Color, modifier: Modifier = Modifier
) {
    Column(
        modifier
            .background(color)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(id = content),
            Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(id = R.dimen.padding_medium),
                bottom = dimensionResource(id = R.dimen.padding_medium)
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantComposeAppPreview() {
    QuadrantComposeTheme {
        QuadrantComposeApp()
    }
}