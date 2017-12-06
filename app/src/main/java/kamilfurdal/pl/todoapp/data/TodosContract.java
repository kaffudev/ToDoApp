package kamilfurdal.pl.todoapp.data;


import android.provider.BaseColumns;

public final class TodosContract {

    public static final class TodosEntry implements BaseColumns{
        //Table name
        public static final String TABLE_NAME = "todos";
        //column (field) names
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_CREATED = "created";
        public static final String COLUMN_EXPIRED = "expired"; // przedawniony
        public static final String COLUMN_DONE = "done";
        public static final String COLUMN_CATEGORY = "category";

    }

    public static final class CategoriesEntry implements BaseColumns{

        public static final String TABLE_NAME = "categories";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_DESCRIPTION = "description";

    }
}
