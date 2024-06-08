import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination

@Composable
fun UserTypeSelection(
    data: UserType,
    imageResId: Int,
    isChecked: Boolean,
    onClick: (UserType) -> Unit
) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(200.dp)
            .clickable {
                onClick(data)
            }
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = data.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Surface(
            color = Color.Black.copy(alpha = 0.3f),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {}

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
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = if(data.name == UserType.CLIENT.toString()) "Cliente" else "Estabelecimento",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun SelectUserType(
    onNavigate: (Destination) -> Unit
) {
    var selectedUserType by remember { mutableStateOf<UserType?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Selecione o seu tipo 😃",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserTypeSelection(
                data = UserType.CLIENT,
                imageResId = R.drawable.usertypeclient,
                isChecked = selectedUserType == UserType.CLIENT
            ) {
                selectedUserType = if (selectedUserType == it) null else it
            }
            Spacer(modifier = Modifier.width(16.dp))
            UserTypeSelection(
                data = UserType.ESTABLISHMENT,
                imageResId = R.drawable.usertypestab,
                isChecked = selectedUserType == UserType.ESTABLISHMENT
            ) {
                selectedUserType = if (selectedUserType == it) null else it
            }
        }
        Spacer(modifier = Modifier.height(70.dp))

        ButtonGeneric(
            text = stringResource(id = R.string.user_select),
            textSize = 18,
            modifier = Modifier
                .width(150.dp)
                .height(43.dp),
            isPrimary = true,
        ) {
            if (selectedUserType == UserType.ESTABLISHMENT) {
                onNavigate(
                    AppDestination.StepOneSignUpEstablishment.route,
                )
            } else {
                onNavigate(
                    AppDestination.StepOneSignUpCustomer.route,
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun UserTypePreview() {
//    UserTypeSelection()
//}
