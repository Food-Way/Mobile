import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.foodway.R

@Composable
fun UserSearchComponent(
//    onSearchClicked: (String) -> Unit,
    vm: SearchUserViewModel
) {
    Surface(
        modifier = Modifier
            .height(105.dp),
        color = MaterialTheme.colors.background
    ) {
        val context = LocalContext.current
        val focusManager = LocalFocusManager.current

        var isFilterDialogVisible by remember { mutableStateOf(false) }
        var selectedFilters by remember { mutableStateOf(emptySet<String>()) }

        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            val queryState = remember { mutableStateOf("") }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(5.dp)
            ) {
                selectedFilters.forEach { filter ->
                    Box(
                        modifier = Modifier
                            .border(
                                2.dp,
                                colorResource(id = R.color.light_gray),
                                RoundedCornerShape(10.dp)
                            )
                            .clickable {
                                val newSelectedFilters = selectedFilters - filter
                                selectedFilters = newSelectedFilters
                            }
                            .padding(5.dp)
                    ) {
                        Text(text = filter)
                    }
                    Spacer(
                        modifier = Modifier
                            .width(5.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .height(52.dp)
                    .border(
                        1.5.dp,
                        Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                TextField(
                    value = queryState.value,
                    singleLine = true,
                    onValueChange = { newValue -> queryState.value = newValue },
                    placeholder = { Text("Digite o nome do usuário") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Ícone de pesquisa"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.filter_icon),
                            contentDescription = "Ícone de filtro",
                            modifier = Modifier.clickable { isFilterDialogVisible = true }
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            focusManager.clearFocus()
                        }
                    )
                )

//                var previousSelectedFilters: Set<String> by remember { mutableStateOf(selectedFilters) }

                if (isFilterDialogVisible) {
                    FilterDialog(
                        selectedFilters = selectedFilters,
                        onFilterSelected = { newSelectedFilters ->
                            selectedFilters = newSelectedFilters
                        },
                        onDismiss = { isFilterDialogVisible = false },
//                        oldSelectedFilters = previousSelectedFilters
                        vm = vm
                    )
                }
            }
        }
    }
}

@Composable
fun FilterDialog(
    selectedFilters: Set<String>,
    onFilterSelected: (Set<String>) -> Unit,
    onDismiss: () -> Unit,
    vm: SearchUserViewModel
) {
    val availableFilters = mapOf(
        "Comentários" to "COMMENTS",
        "Upvotes" to "UPVOTES",
        "Avaliação" to "RELEVANCE"
    )

    var filter by remember {
        mutableStateOf("")
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(275.dp)
                    .height(300.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    text = "Filtro de usuário",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                availableFilters.forEach { (displayName, internalValue) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            modifier = Modifier
                                .height(5.dp),
                            checked = selectedFilters.contains(internalValue),
                            onCheckedChange = { isChecked ->
                                val newSelectedFilters = if (isChecked) {
                                    selectedFilters + internalValue
                                } else {
                                    selectedFilters - internalValue
                                }
                                filter = internalValue
                                vm.updateFilter(internalValue)
                                onFilterSelected(newSelectedFilters)
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = colorResource(id = R.color.red),
                                checkmarkColor = colorResource(id = R.color.white)
                            )
                        )
                        Text(
                            text = displayName,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.width(106.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.light_black),
                            contentColor = colorResource(id = R.color.white)
                        ),
                        onClick = {
                            onFilterSelected(emptySet())
                        }
                    ) {
                        Text("Limpar")
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Button(
                        modifier = Modifier.width(106.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.red),
                            contentColor = colorResource(id = R.color.white)
                        ),
                        onClick = {
                            onDismiss()
                            vm.getAllEstablishments(filter)
                        }
                    ) {
                        Text("Filtrar")
                    }
                }
            }
        }
    }
}

