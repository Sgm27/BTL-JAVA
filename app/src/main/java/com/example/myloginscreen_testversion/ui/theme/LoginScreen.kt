
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myloginscreen_testversion.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf("user@example.com") }
    var password by remember { mutableStateOf("Bắt buộc") }
    var emailCleared by remember { mutableStateOf(false) }
    var passwordCleared by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "Đăng nhập",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "NHẬP ĐỊA CHỈ EMAIL CỦA BẠN",
            style = MaterialTheme.typography.labelMedium.copy(
                color = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email Input Field
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },

            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    if (focusState.isFocused && !emailCleared) {
                        email = ""
                        emailCleared = true
                    }
                },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF6F6F6),
                unfocusedContainerColor = Color(0xFFFFFFFF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Password Input Field
        TextField(
            value = password,
            onValueChange = {
                password = if (it == "Bắt buộc") "" else it
            },
            label = { Text("Mật khẩu") },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    if (focusState.isFocused && !passwordCleared) {
                        password = ""
                        passwordCleared = true
                    }
                },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF6F6F6),
                unfocusedContainerColor = Color(0xFFFFFFFF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            visualTransformation = if (passwordCleared) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = true,
            maxLines = 1,

        )

        Spacer(modifier = Modifier.height(32.dp))

        // Login Button
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor =
                if (
                    email != "user@example.com"
                    && password != "Bắt buộc"
                    && email.isNotEmpty()
                    && password.isNotEmpty()
                    )
                    Color(0xFF1493ff) else Color(0xFFB0D4FA),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Đăng nhập",
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Quên mật khẩu?",
            style = MaterialTheme.typography.labelMedium.copy(
                color = Color.Blue
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .clickable {
                    // Do something when "Quên mật khẩu?" is clicked
                }
        )

        Spacer(modifier = Modifier.height(56.dp))

        Text(
            text = "PHƯƠNG THỨC ĐĂNG NHẬP KHÁC",
            style = MaterialTheme.typography.labelMedium.copy(
                color = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Other Login Methods
        OtherLoginButton(
            text = "Tiếp tục với Apple",
            icon = painterResource(id = R.drawable.ic_apple)
        )
        Spacer(modifier = Modifier.height(12.dp))
        OtherLoginButton(
            text = "Tiếp tục với Google",
            icon = painterResource(id = R.drawable.ic_google),
            icon_size = 28
        )
        Spacer(modifier = Modifier.height(12.dp))
        OtherLoginButton(
            text = "Tiếp tục với Facebook",
            icon = painterResource(id = R.drawable.ic_facebook),
            icon_size = 32
        )
        Spacer(modifier = Modifier.height(12.dp))
        OtherLoginButton(
            text = "Tiếp tục với SSO",
            icon = painterResource(id = R.drawable.ic_sso)
        )
    }
}

@Composable
fun OtherLoginButton(text: String, text_font_size: Int = 17, text_color: Long = 0xFF5b5b5b, icon: Painter, icon_size: Int = 24) {
    OutlinedButton(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(16.dp),
        border = null,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
        )
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(icon_size.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontSize = text_font_size.sp,
            color = Color(text_color)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
