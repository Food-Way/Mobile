import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.model.SelectTypeUser
import com.example.foodway.domain.model.UserType
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.CoilImage

@Composable
fun SelectUserType(
    data: UserType,
    imageResId: Int,
    onClick: (UserType) -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(200.dp)
            .clickable {
                isChecked = !isChecked
                onClick(data)
            }
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)) // Adiciona a borda
            .padding(12.dp) // Ajusta a margem

    ) {

       // CoilImage(
        // photo = data.photo,
         //description = data.name,
        //  modifier = Modifier
            //.fillMaxSize()
        //)
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = data.name,
            modifier = Modifier
                .fillMaxSize()
        )

        if (isChecked) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp),
                colors = CheckboxDefaults.colors(
                    checkmarkColor = colorResource(id = R.color.white),
                    checkedColor = Color.Transparent
                )
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 4.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = data.name,
                color = colorResource(id = R.color.white),
            )
        }

    }
}

@Composable
fun UserTypeSelection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Seleção", // Título adicionado
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SelectUserType(data = UserType.CLIENT, imageResId = R.drawable.usertypeclient) {}
            Spacer(modifier = Modifier.width(16.dp))
            SelectUserType(data = UserType.ESTABLISHMENT, imageResId = R.drawable.usertypestab) {}
        }
        Spacer(modifier = Modifier.height(70.dp))

        // Botão adicionado abaixo dos quadrados
        ButtonGeneric(
            text = stringResource(id = R.string.user_select),
            modifier = Modifier
                .width(150.dp)
                .height(43.dp),
            isPrimary = true,
        ) {
            // Ação do botão
        }
    }
}



@Preview(showBackground = true)
@Composable
fun UserTypePreview() {
    UserTypeSelection()
}
