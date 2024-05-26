
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.presentation.searchUser.SearchClient
import com.example.foodway.presentation.searchUser.SearchEstablishment
import com.example.foodway.presentation.searchUser.SearchFavorites
import com.example.foodway.presentation.searchUser.SearchUserViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun TabScreen(
    vm: SearchUserViewModel
) {

    val tabs = listOf("", "", "")
    val tabsIconsSelected = listOf(
        painterResource(id = R.drawable.location_white_icon),
        painterResource(id = R.drawable.person_white_icon),
        painterResource(id = R.drawable.heart_white_icon)
    )

    val tabsIconsUnselected = listOf(
        painterResource(id = R.drawable.location_icon),
        painterResource(id = R.drawable.person_icon),
        painterResource(id = R.drawable.heart_icon)
    )

    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    val transition = updateTransition(targetState = pagerState.currentPage, label = "TabTransition")
    val indicatorColor by transition.animateColor(
        transitionSpec = { tween(durationMillis = 700) },
        label = "ColorTransition"
    ) { page ->
        when (page) {
            0 -> colorResource(id = R.color.light_black)
            1 -> colorResource(id = R.color.light_black)
            else -> colorResource(id = R.color.red)
        }
    }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        Box(
            modifier = Modifier
                .pagerTabIndicatorOffset(
                    pagerState = pagerState,
                    tabPositions = tabPositions,
                )
                .fillMaxHeight()
                .background(
                    indicatorColor,
                    RoundedCornerShape(50.dp)
                ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(33.dp)
            ) {
                Image(
                    painter = tabsIconsSelected[pagerState.currentPage],
                    contentDescription = "Icone de" + tabs[pagerState.currentPage],
                    modifier = Modifier
                        .size(17.dp)
                )
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = tabs[pagerState.currentPage],
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .width(300.dp)
            .height(650.dp)
    ) {
        TabRow(
            contentColor = colorResource(id = R.color.light_gray),
            backgroundColor = colorResource(id = R.color.light_gray),
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier
                .height(25.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(50.dp))
                .border(1.dp, Color.Transparent),
            indicator = indicator
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    modifier = Modifier
                        .fillMaxWidth(),
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    content = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .height(35.dp)
                        ) {
                            Image(
                                painter = tabsIconsUnselected[index],
                                contentDescription = "Icone de" + tabs[pagerState.currentPage],
                                modifier = Modifier
                                    .size(17.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = title,
                                color = Color.Black,
                                fontSize = 9.sp
                            )
                        }
                    },
                    selectedContentColor = Color.Yellow
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            count = tabs.size,
            modifier = Modifier
                .fillMaxWidth()
        ) { index ->
            when (index) {
                0 -> SearchEstablishment(
                    vm = vm
                )
                1 -> SearchClient(
                    vm = vm
                )
                else -> SearchFavorites()
            }
        }
    }
}