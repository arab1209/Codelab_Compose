package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.theme.ComposestudyTheme

class LayoutComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposestudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingList(modifier = Modifier.padding(innerPadding)) // innerPadding 적용
                }
            }
        }
    }
}

@Composable
fun Greeting2(
    text: String, text2: String, text3: String, text4: String, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(8.dp) // 외부 여백을 줄여서 각 박스 간 간격을 더 줄일 수 있음
            .fillMaxWidth() // 가로 전체 차지
            .shadow(8.dp, RoundedCornerShape(16.dp)) // 입체감과 둥근 모서리 적용
            .clip(RoundedCornerShape(16.dp)) // 둥근 모서리 적용
            .background(MaterialTheme.colorScheme.primary) // 배경 색상
    ) {
        Row(
            modifier = Modifier.padding(16.dp), // 내부 여백
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween // 왼쪽, 오른쪽 공간 배분
        ) {
            Column {
                Text(text)
                Text(text2)
                Text(text3)
            }
            Text(text4)
        }
    }
}

@Composable
fun GreetingList(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        // Greeting2 컴포저블을 세 번 호출하여 박스가 세로로 정렬되도록 함
        Greeting2(text = "Hello", text2 = "Android 1", text3 = "Test 1", text4 = "Row Test 1")
        Greeting2(text = "Hi", text2 = "Android 2", text3 = "Test 2", text4 = "Row Test 2")
        Greeting2(text = "Hey", text2 = "Android 3", text3 = "Test 3", text4 = "Row Test 3")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposestudyTheme {
        GreetingList() // 여러 Greeting2가 포함된 GreetingList를 미리보기로 사용
    }
}
