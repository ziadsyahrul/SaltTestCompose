package com.ziadsyahrul.salttestcompose

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ziadsyahrul.salttestcompose.model.UserResponse
import com.ziadsyahrul.salttestcompose.ui.theme.SaltComposeTestTheme

@Composable
fun UserListItem(userResponse: UserResponse) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        elevation = 10.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
            Toast.makeText(context, "This is ${userResponse.first_name}", Toast.LENGTH_SHORT).show()
        }) {
            AsyncImage(
                model = userResponse.avatar,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .weight(1f, fill = true),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = userResponse.first_name,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(0.dp, 2.dp),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = userResponse.email,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(0.dp, 2.dp),
                    textAlign = TextAlign.Start
                )

            }
        }


//        }
//        Column(
//            modifier = Modifier
//                .padding(10.dp)
//                .fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = userResponse.yearOfBirth.toString(),
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif
//            )
//
//            Spacer(modifier = Modifier.padding(10.dp))
//
//            Text(
//                text = "Title: ${userResponse.name}",
//                modifier = Modifier.fillMaxWidth(),
//                fontSize = 15.sp,
//                fontWeight = FontWeight.Normal,
//                fontFamily = FontFamily.SansSerif
//            )
//
//            Spacer(modifier = Modifier.padding(5.dp))
//
//            Text(
//                text = "Status: ${userResponse.gender}",
//                modifier = Modifier.fillMaxWidth(),
//                fontSize = 15.sp,
//                fontWeight = FontWeight.Normal,
//                fontFamily = FontFamily.SansSerif
//            )
//
//            Spacer(modifier = Modifier.padding(5.dp))
//
//            Text(
//                text = "Status: ${userResponse.house}",
//                modifier = Modifier.fillMaxWidth(),
//                fontSize = 15.sp,
//                fontWeight = FontWeight.Normal,
//                fontFamily = FontFamily.SansSerif
//            )
//
//            AsyncImage(
//                model = userResponse.image,
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .padding(8.dp)
//                    .size(60.dp)
//                    .clip(CircleShape)
//            )
//
//        }
        //}
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun listPreview() {
    SaltComposeTestTheme() {
        UserListItem(userResponse = UserResponse(1, "Ziad", "male", ""))
    }
}


















