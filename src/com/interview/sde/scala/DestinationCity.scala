//https://leetcode.com/problems/destination-city
object DestinationCity {
  def destCity(paths: List[List[String]]): String = {
    val departures = paths.map(_.head)
    val arrivals = paths.map(_.last)
    arrivals.diff(departures).head
  }
}
