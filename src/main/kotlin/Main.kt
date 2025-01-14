import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.*
import androidx.compose.ui.zIndex
import controls.*
import drawing.FractalPainter
import drawing.convertation.Plane
import math.fractals.Mandelbrot
import kotlin.math.*
import drawing.convertation.ColorFunc

@Composable
@Preview
fun App(){
    Mandelbrot.funcNum = 3
    val fp = remember {FractalPainter(Mandelbrot)}
    fp.colorNum = ColorFunc(2)
    fp.plane = Plane(-2.0, 1.0, -1.0, 1.0, 0f, 0f)
    MaterialTheme{
        Scaffold(
            topBar = {
                var dynamicIterationsCheck by remember { mutableStateOf(false) }
                var isVideoDialogVisible by remember { mutableStateOf(false) }
                menu(
                    saveImage = { TODO("ПЕРЕДАТЬ ФУНКЦИЮ ДЛЯ СОХРАНЕНИЯ КАК КАРТИНКИ")},
                    saveFractal = { TODO("ПЕРЕДАТЬ ФУНКЦИЮ ДЛЯ СОХРАНИНИЯ КАК СОБСТВЕННЫЙ ТИП")},
                    openF = { TODO("ДЛЯ ОТКРЫТИЯ ФАЙЛА В СОБСТВЕННОМ ТИПЕ")},
                    back = { TODO("ОТМЕНА ДЕЙСТВИЯ")},
                    showVideoDialog = {},
                    addFrames = {TODO("Добавления Кадров к Экскурсии")},
                    //ТУТ ПЕРЕДАЕТСЯ КАРТА {НАЗВАНИЕ -> ФУНКЦИЯ}, в неё мохно передавать цветовые схемы, сколько угодно.
                    //т.е когда пользователь будет нажимать на название, то вызывается функция, которая меняет фрактал
                    themesMap = mapOf(),
                    //Это Boolean значение для динамических итераций, Переключатель True/False. Тут менять ничего не нужно.
                    //Нужно просто реализовать логику изменения
                    dynamicIterationsCheck = dynamicIterationsCheck,
                    dynamicIterationsCheckChange =  {dynamicIterationsCheck = it},
                )
            },
            modifier = Modifier.fillMaxSize()){
            Box(
                Modifier.fillMaxSize()
            ){
                mainFractalWindow(fp)
            }
        }
    }
}


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Множество Мандельброта",
        state = rememberWindowState(
            width = 800.dp,
            height = 600.dp,
            placement = WindowPlacement.Floating,
            position = WindowPosition(100.dp, 100.dp),
            isMinimized = false
        ),
    ) {
        App()
    }
}
