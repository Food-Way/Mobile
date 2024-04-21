import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

private enum class BoxState {
    Small,
    Large
}

@ExperimentalPagerApi
@Composable
fun TabScreen() {
    val tabs = listOf("Estabelecimentos", "Clientes")
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    val transition = updateTransition(targetState = pagerState.currentPage, label = "TabTransition")
    val indicatorColor by transition.animateColor(
        transitionSpec = { tween(durationMillis = 700) },
        label = "ColorTransition"
    ) { page ->
        when (page) {
            0 -> Color.LightGray
            1 -> Color.Red
            else -> Color.LightGray
        }
    }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        Box(
            modifier = Modifier
                .pagerTabIndicatorOffset(
                    pagerState = pagerState,
                    tabPositions = tabPositions
                )
                .fillMaxWidth()
                .height(2.dp)
                .background(indicatorColor)
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
            indicator = indicator
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(text = title, color = Color.Black) }
                )
            }
        }

        HorizontalPager(state = pagerState, count = tabs.size) { index ->
            when (index) {
                0 -> Text("Conteúdo da aba de Estabelecimentos")
                1 -> Text("Conteúdo da aba de Clientes")
                else -> Text("Conteúdo extra")
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TabScreenPreview() {
    TabScreen()
}