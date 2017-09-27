package pc.wlt.com.superlibrary;


/**
 * @author leitao
 * @fileName pkg.shi.com.views
 * @date 2016/4/20
 * @update by     on
 */
public interface MView<T> {
    void showProgress();
    void hideProgress();
    void showLoadFailMsg(String msg);
    void refreshData(String response, int position);
}
