
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    message: String = stringResource(R.string.default_error_message),
    retryAction: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        Text(
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Gray,
            text = message
        )
        Image(
            painter = painterResource(
                id = R.drawable.cat_error
            ),
            contentDescription = "Ocorreu um erro",
            Modifier.size(300.dp)
        )
        Button(onClick = { retryAction() }) {
            Text(
                text = stringResource(id = R.string.try_again)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorViewPreview() {
    ErrorView {}
}