object Main {
  /*Напишите программу, которая вычисляет ежемесячный оклад сотрудника после вычета налогов.
   На вход вашей программе подается значение годового дохода до вычета налогов,
   размер премии – в процентах от годового дохода и компенсация питания.
   */
  def salary(YearVal: Float, Add: Float, Nutr: Float): Unit = {
    val Summary: Double = (YearVal + YearVal * Add / 100 + Nutr) / 12 * 0.87
    println(Summary)
  }

  /* Напишите программу, которая рассчитывает для каждого сотрудника отклонение(в процентах)
   от среднего значения оклада на уровень всего отдела.
   В итоговом значении должно учитываться в большую или меньшую сторону отклоняется размер оклада.
   На вход вышей программе подаются все значения, аналогичные предыдущей программе,
   а также список со значениями окладов сотрудников отдела 100, 150, 200, 80, 120, 75.
  */
  def salaryDeviation(YearVal: Float, Add: Float, Nutr: Float, DepListSal: List[Double]): Unit = {
    val Summary: Double = (YearVal + YearVal * Add / 100 + Nutr) / 12 * 0.87
    var AverDepSal: Double = 0
    AverDepSal = DepListSal.sum / DepListSal.length
    println(Summary)
    println(AverDepSal)
    if (Summary < AverDepSal) {
      print("Ваша зарплата меньше средней по отделу на ")

    } else {
      println("Ваша зарплата больше средней по отделу на ")
    }
    println(Math.abs(AverDepSal - Summary))
  }

  /*

  // var salListAdd=(NewElSal: Double, NewDepListSal: List[Double]) => NewDepListSal:+ NewElSal
  /*  def salListSort(YearVal: Float, Add: Float, Nutr: Float, DepListSal: List[Double]): Unit = {
    val Summary: Double = (YearVal + YearVal * Add / 100 + Nutr) / 12 * 0.87
    var AverDepSal: Double = 0
    AverDepSal = DepListSal.sum / DepListSal.length
    val NewDepListSal = {
      DepListSal :+ 350000 :+ 90000
    }
    println(NewDepListSal)
    println(AverDepSal)

  }*/

 */
  def main(args: Array[String]): Unit = {
    val InitStr: String = "Hello, Scala!"
    println(InitStr)
    var OpStr: String = InitStr.reverse
    println(OpStr)
    OpStr = InitStr.toLowerCase()
    println(OpStr)
    OpStr = InitStr.replace("!", "")
    println(OpStr)
    OpStr = InitStr + " " + "and goodbye python!"
    println(OpStr)
    salary(250000, 10, 10000)
    val InDepListSal: List[Double] = List(100.3, 150.2, 200.1, 80.2, 120.2, 75.5)
    salaryDeviation(250000, 10, 10000, InDepListSal)
    /* Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
       Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему.
       */
    var NewSal: Double=350000
    val InDepListSal2: List[Double] = InDepListSal :+ NewSal:+ 90000
    println(InDepListSal2)
    val SortsalListAdd: List[Double] = InDepListSal2.sorted
    println(SortsalListAdd)
/*  Кажется, вы взяли в вашу команду еще одного сотрудника и предложили ему оклад 130 тысяч.
Вычислите самостоятельно номер сотрудника в списке так, чтобы сортировка не нарушилась и добавьте его на это место.
*/
    NewSal=130000
    var num: Int =0
    val Index_To_Insert = SortsalListAdd.indexWhere(x => x > NewSal)
    // вставляем в позицию найденного элемента один новый элемент
    val New_Salaries_List_Sorted = SortsalListAdd.patch(Index_To_Insert, List(NewSal), 0)
    println(New_Salaries_List_Sorted + "- список с новым элементом по-прежнему отсортирован")
/*  g.Попробуйте вывести номера сотрудников из полученного списка, которые попадают под категорию middle.
    На входе программе подается «вилка» зарплаты специалистов уровня middle.
 */
  val Salaries_List_Sorted = New_Salaries_List_Sorted
  println(Salaries_List_Sorted + " - Исходный список зарплат")

  // вилка зарплат сотрудников
  val Middle_Min_Salary: Double = 100
  val Middle_Max_Salary: Double = 150
  println(s"Ищем индексы в списке для сотрудников с зарплатами от $Middle_Min_Salary до $Middle_Max_Salary")

  // фильтр и мап
  val Middle_Indexes_v2 = Salaries_List_Sorted.zipWithIndex.filter(x => (Middle_Min_Salary <= x._1) && (x._1 <= Middle_Max_Salary)).map(x => x._2)
  println(Middle_Indexes_v2 + "- индексы искомых сотрудников")
    /*  h.Однако наступил кризис и ваши сотрудники требуют повысить зарплату.
        Вам необходимо проиндексировать зарплату каждого сотрудника на уровень инфляции –7 %
     */
  println(Salaries_List_Sorted + " - исходный список зарплат")
  //уровень инфляции
  val Inflation_Rate = 7.0
  val Crisis_Salaries_List_ = Salaries_List_Sorted.map(x => x * (1 + Inflation_Rate/100))
      println(Crisis_Salaries_List_ + s" - кризисный список зарплат, инфл.уровень $Inflation_Rate%")
  }

}
