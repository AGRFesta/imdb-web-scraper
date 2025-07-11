package org.agrfesta.movies.iws.clients

interface ImdbClient {

    /**
     * @return the number of seasons of [seriesId].
     * @param seriesId IMDB Series ID.
     */
    fun getNumberOfSeasons(seriesId: String): Int

}
