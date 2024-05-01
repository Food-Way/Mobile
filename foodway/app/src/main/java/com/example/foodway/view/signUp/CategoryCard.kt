import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.model.Culinary
import com.example.foodway.view.components.CoilImage

@Composable
fun CategoryCard(
    data: Culinary
) {
    var isChecked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable { isChecked = !isChecked }
    ) {

        CoilImage(
            photo = data.photo,
            description = data.name,
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

//@Preview(showBackground =true)
//@Composable
//fun CategoryCardPreview() {
//    CategoryCard(category = "Brasileira")
//}
